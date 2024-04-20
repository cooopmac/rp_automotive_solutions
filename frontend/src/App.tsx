import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Login from "./components/login";
import RegisterAccount from "./components/registerAccount";
import Navbar from "./components/navbar";
import RegistrationForm from "./components/registrationForm";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/login" Component={Login} />
        <Route path="/register" Component={RegisterAccount} />
        <Route path="/register-shop" Component={RegistrationForm} />
        <Route path="/dashboard" Component={Navbar} />
      </Routes>
    </Router>
  );
}

export default App;
