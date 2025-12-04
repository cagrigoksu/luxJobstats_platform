import { FormEvent, useState } from 'react'

export default function SignUp() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [confirm, setConfirm] = useState('')

  const onSubmit = (e: FormEvent) => {
    e.preventDefault()
    if (password !== confirm) return alert('Passwords do not match')

    alert(`Sign up with:\n${email}`)
    // TODO: call /auth/register
  }

  return (
    <section className="centered">
      <form className="card" onSubmit={onSubmit}>
        <h2>Create Account</h2>

        <table>
          <thead></thead>
          <tbody>
            <tr>
              <td>
                <input 
                  type="email" 
                  value={email} 
                  onChange={(e) => setEmail(e.target.value)} 
                  placeholder="you@example.com"
                  required/>
              </td>
            </tr>
            <tr>
              <td>
                <input
                  type="password" 
                  value={password} 
                  onChange={(e) => setPassword(e.target.value)} 
                  placeholder="password"
                  required/>
              </td>
            </tr>
            <tr>
              <td>
                <input
                  type="password" 
                  value={confirm} 
                  onChange={(e) => setConfirm(e.target.value)} 
                  placeholder="confirm password"
                  required/>
              </td>
            </tr>    
          </tbody>      
        </table>

        <button type="submit" className="btn">Sign up</button>
      </form>
    </section>
  )
}
