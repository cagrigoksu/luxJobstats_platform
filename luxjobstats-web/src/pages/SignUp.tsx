import { FormEvent, useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { isEmail, isStrongPassword } from '../utils/validators';
import { register } from '../services/authService';

export default function SignUp() {
  const nav = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirm, setConfirm] = useState('');
  const [loading, setLoading] = useState(false);
  const [err, setErr] = useState<string | null>(null);

  const onSubmit = async (e: FormEvent) => {
    e.preventDefault();
    setErr(null);

    if (!isEmail(email)) return setErr('Invalid email');
    if (!isStrongPassword(password)) return setErr('Password must be at least 8 chars');
    if (password !== confirm) return setErr('Passwords do not match');

    try {
      setLoading(true);
      await register({ email, password, confirmPassword: confirm });
      nav('/dashboard');
    } catch (ex: any) {
      setErr(ex?.response?.data || 'Sign up failed.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <section className="centered">
      <form className="card" onSubmit={onSubmit}>
        <h2>Create Account</h2>

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
            <tr>
              <td>
                <input
                  type="password"
                  value={confirm}
                  onChange={(e) => setConfirm(e.target.value)}
                  placeholder="confirm password"
                />
              </td>
            </tr>
          </tbody>
        </table>

        <button type="submit" className="btn" disabled={loading}>
          {loading ? 'Creating…' : 'Sign up'}
        </button>

        <div style={{ fontSize: 14, marginTop: 8 }}>
          Already have an account? <Link to="/signin" className="btn-link">Sign in</Link>
        </div>
      </form>
    </section>
  );
}
