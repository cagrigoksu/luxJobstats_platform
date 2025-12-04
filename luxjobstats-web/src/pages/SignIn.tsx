import { FormEvent, useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { isEmail, isStrongPassword } from '../utils/validators';
import { login } from '../services/authService';

export default function SignIn() {
  const nav = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loading, setLoading] = useState(false);
  const [err, setErr] = useState<string | null>(null);

  const onSubmit = async (e: FormEvent) => {
    e.preventDefault();
    setErr(null);

    if (!isEmail(email)) return setErr('Invalid email');
    if (!isStrongPassword(password)) return setErr('Password too short');

    try {
      setLoading(true);
      await login({ email, password });
      nav('/dashboard');  
    } catch (ex: any) {
      setErr(ex?.response?.data || 'Sign in failed.');
    } finally {
      setLoading(false);
    }
  };


  return (
    <section className="centered">
      <form className="card" onSubmit={onSubmit}>
        <h2>Sign In</h2>

        {err && <div style={{ color: '#ff8a8a' }}>{err}</div>}

        <table>
          <tbody>
            <tr>
              <td>
                <input
                  type="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  placeholder="you@example.com"
                />
              </td>
            </tr>
            <tr>
              <td>
                <input
                  type="password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  placeholder="password"
                />
              </td>
            </tr>
          </tbody>
        </table>

        <button type="submit" className="btn" disabled={loading}>
          {loading ? 'Signing in…' : 'Sign in'}
        </button>

        <div style={{ fontSize: 14, marginTop: 8 }}>
          No account? <Link to="/signup" className="btn-link">Create one</Link>
        </div>
      </form>
    </section>
  );
}
