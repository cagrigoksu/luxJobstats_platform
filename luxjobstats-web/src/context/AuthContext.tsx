import { createContext, useContext, useEffect, useMemo, useState } from 'react';
import { clearTokens, getAccessToken } from '../api/client';

type AuthState = {
  isAuthenticated: boolean;
  signOut: () => void;
};

const AuthContext = createContext<AuthState | undefined>(undefined);

export function AuthProvider({ children }: { children: React.ReactNode }) {
  const [token, setToken] = useState<string | null>(getAccessToken());

  useEffect(() => {
    const onStorage = () => setToken(getAccessToken());
    window.addEventListener('storage', onStorage);
    return () => window.removeEventListener('storage', onStorage);
  }, []);

  const value = useMemo<AuthState>(() => ({
    isAuthenticated: !!token,
    signOut: () => {
      clearTokens();
      setToken(null);
    },
  }), [token]);

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
}

export function useAuth() {
  const ctx = useContext(AuthContext);
  if (!ctx) throw new Error('useAuth must be used within AuthProvider');
  return ctx;
}
