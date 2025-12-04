import { Routes, Route } from 'react-router-dom'
import Header from './components/Header'
import Home from './pages/Home'
import SignIn from './pages/SignIn'
import SignUp from './pages/SignUp'
import Dashboard from './pages/Dashboard';
import Protected from './components/Protected';
import { AuthProvider } from './context/AuthContext';

export default function App() {
  return (
    <AuthProvider>
      <div className="app-root">
        <Header />
        <main className="app-main">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/signin" element={<SignIn />} />
            <Route path="/signup" element={<SignUp />} />
            <Route
              path="/dashboard"
              element={
                <Protected>
                  <Dashboard />
                </Protected>
              }
            />
          </Routes>
        </main>
      </div>
    </AuthProvider>
  );
}
