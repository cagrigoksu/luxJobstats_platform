import { FormEvent, useState } from 'react'

export default function SignIn() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  const onSubmit = (e: FormEvent) => {
    e.preventDefault()
    alert(`Sign in with:\n${email}`)
    // TODO: call /auth/login
  }

  return (
    <section className="centered">
      <form className="card" onSubmit={onSubmit}>
        <h2>Sign In</h2>

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
          </tbody>
        </table>

        <button type="submit" className="btn">Sign in</button>
      </form>
    </section>
  )
}
