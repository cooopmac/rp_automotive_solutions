import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Login from "./components/login";
import { Register } from "./components/register";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/login" Component={Login} />
        <Route path="/register" Component={Register} />
      </Routes>
    </Router>
  );
}

export default App;
