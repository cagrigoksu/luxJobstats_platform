import axios from "axios";

const baseURL = import.meta.env.VITE_LJS_AUTH_API_BASE_URL as string;

export const api = axios.create({
    baseURL,
    headers: {'Content-Type':'application/json'}
});

// for jwt
const TOKEN_KEY = 'accessToken';
const REFRESH_KEY = 'refreshToken';

export function getAccessToken() {
  return localStorage.getItem(TOKEN_KEY);
}

export function setTokens(accessToken: string, refreshToken?: string) {
  localStorage.setItem(TOKEN_KEY, accessToken);
  if (refreshToken) localStorage.setItem(REFRESH_KEY, refreshToken);
}

export function clearTokens() {
  localStorage.removeItem(TOKEN_KEY);
  localStorage.removeItem(REFRESH_KEY);
}

export function getRefreshToken() {
  return localStorage.getItem(REFRESH_KEY);
}

// autorfresh if token is expired
let isRefreshing = false;

api.interceptors.response.use(
  (res) => res,
  async (err) => {
    const original = err.config;
    if (err?.response?.status === 401 && !original._retry && getRefreshToken() && !isRefreshing) 
    {
      original._retry = true;
      try {
        isRefreshing = true;
        const refreshed = await axios.post(
          `${baseURL}/auth/refresh`,
          { refreshToken: getRefreshToken() },
          { headers: { 'Content-Type': 'application/json' } }
        );
        const newAccess = refreshed.data?.accessToken;
        const newRefresh = refreshed.data?.refreshToken;
        if (newAccess) setTokens(newAccess, newRefresh);
        isRefreshing = false;
        // retry original request
        return api(original);
      } 
      catch (e) 
      {
        isRefreshing = false;
        clearTokens();
      }
    }
    return Promise.reject(err);
  }
);