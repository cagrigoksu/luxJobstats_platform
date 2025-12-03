import { Link, useLocation } from 'react-router-dom'

export default function Header() {
  const { pathname } = useLocation()

  return (
    <header className="app-header">
      <div className="brand">LuxJobStats</div>

      <nav className="nav">
        {pathname !== '/signin' && (
          <Link className="btn-link" to="/signin">Sign in</Link>
        )}
        {pathname !== '/signup' && (
          <Link className="btn" to="/signup">Sign up</Link>
        )}
      </nav>
    </header>
  )
}
