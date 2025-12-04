import { createContext, useContext, useEffect, useState } from "react";
import { getAccessToken, clearTokens } from "../api/client";

type AuthState = {
  isAuthenticated: boolean;
  signOut: () => void;
};

const AuthContext = createContext<AuthState | undefined>(undefined);

export function AuthProvider({ children }: { children: React.ReactNode }) {
  const [isAuthenticated, setIsAuthenticated] = useState<boolean>(!!getAccessToken());

  //! listen for login/logout events from setTokens() > client.ts
  useEffect(() => {
    const handler = () => {
      const token = getAccessToken();
      setIsAuthenticated(!!token);
    };

    window.addEventListener("auth-changed", handler);
    return () => window.removeEventListener("auth-changed", handler);
  }, []);

  const signOut = () => {
    clearTokens();
    setIsAuthenticated(false);
    window.dispatchEvent(new Event("auth-changed"));
  };

  return (
    <AuthContext.Provider value={{ isAuthenticated, signOut }}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  const ctx = useContext(AuthContext);
  if (!ctx) throw new Error("useAuth must be inside AuthProvider");
  return ctx;
}
