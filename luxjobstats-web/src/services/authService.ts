import { api, setTokens } from '../api/client';

export type LoginRequest = { email: string; password: string; };
export type RegisterRequest = { email: string; password: string; confirmPassword: string; };

export type AuthResponse = {
  accessToken: string;
  refreshToken?: string;
  //TODO: include id, email, roles, etc
};

export async function login(payload: LoginRequest): Promise<AuthResponse> {

    const { data } = await api.post<AuthResponse>('/auth/login', payload);

  if (data?.accessToken) {
    setTokens(data.accessToken, data.refreshToken);
  }
  return data;
}

export async function register(payload: RegisterRequest): Promise<AuthResponse> {

  const { data } = await api.post<AuthResponse>('/auth/register', payload);

  if (data?.accessToken) {
    setTokens(data.accessToken, data.refreshToken);
  }
  
  return data;
}
