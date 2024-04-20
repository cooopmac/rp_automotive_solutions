import React, { useState, FormEvent } from "react";
import axios, { AxiosError } from "axios"; // Import AxiosError for proper error typing
import { Button } from "@/components/ui/button";
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { useNavigate } from "react-router-dom";

export default function RegisterAccount() {
  const [email, setEmail] = useState<string>("");
  const [password, setPassword] = useState<string>("");
  const navigate = useNavigate();

  const handleSubmit = async (
    event: FormEvent<HTMLFormElement>
  ): Promise<void> => {
    event.preventDefault();
    try {
      await axios.post("http://localhost:8080/api/register", {
        email, // Assuming 'email' is the correct field expected by the backend
        password,
      });

      console.log("Account created successfully");
      navigate("/login"); // Redirect to login on successful registration
      // Optionally redirect the user or handle the response further
    } catch (error: unknown) {
      // Correctly catch the error as an unknown type
      const e = error as AxiosError; // Type assertion to AxiosError
      if (e.response) {
        console.error("Failed to create account:", e.response.data);
      } else {
        console.error("An unexpected error occurred:", e.message);
      }
      // Implement more sophisticated error handling here
    }
  };

  return (
    <div className="flex justify-center h-screen items-center">
      <Card className="mx-auto max-w-sm">
        <CardHeader>
          <CardTitle className="text-xl">Sign Up</CardTitle>
          <CardDescription>
            Enter your information to create an account
          </CardDescription>
        </CardHeader>
        <CardContent>
          <form onSubmit={handleSubmit} className="grid gap-4">
            <div className="grid gap-2">
              <Label htmlFor="email">Email</Label>
              <Input
                id="email"
                type="email"
                required
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>
            <div className="grid gap-2">
              <Label htmlFor="password">Password</Label>
              <Input
                id="password"
                type="password"
                required
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>
            <Button type="submit" className="w-full">
              Create an account
            </Button>
          </form>
          <div className="mt-4 text-center text-sm">
            Already have an account?{" "}
            <a href="/login" className="underline">
              Sign in
            </a>
          </div>
        </CardContent>
      </Card>
    </div>
  );
}
