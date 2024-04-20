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

export default function RegistrationForm() {
  return (
    <div className="flex justify-center h-screen items-center">
      <Card className="mx-auto max-w-sm">
        <CardHeader>
          <CardTitle className="text-xl">Register Your Shop </CardTitle>
          <CardDescription>
            Enter your information to register your shop
          </CardDescription>
        </CardHeader>
        <CardContent>
          <div className="grid gap-4">
            <div>
              <Label htmlFor="first-name">Shop Name</Label>
              <Input id="first-name" type="text" required />
            </div>
            <div className="">
              <Label htmlFor="first-name">Owners Name</Label>
              <Input id="first-name" type="text" required />
            </div>
            <div className="grid grid-cols-2 gap-4">
              <div className="grid gap-2">
                <Label htmlFor="first-name">Address</Label>
                <Input id="first-name" type="text" required />
              </div>
              <div className="grid gap-2">
                <Label htmlFor="last-name">City</Label>
                <Input id="last-name" type="text" required />
              </div>
            </div>
            <div className="grid grid-cols-2 gap-4">
              <div className="grid gap-2">
                <Label htmlFor="first-name">Province</Label>
                <Input id="first-name" type="text" required />
              </div>
              <div className="grid gap-2">
                <Label htmlFor="last-name">Postal Code</Label>
                <Input id="last-name" type="text" required />
              </div>
            </div>
            <div className="grid gap-2">
              <Label htmlFor="email">Phone Number</Label>
              <Input id="email" type="text" required />
            </div>
            <div className="grid grid-cols-2 gap-4">
              <div className="grid gap-2">
                <Label htmlFor="first-name">Contact Email</Label>
                <Input id="first-name" type="email" required />
              </div>
              <div className="grid gap-2">
                <Label htmlFor="last-name">E-Transfer Email</Label>
                <Input id="last-name" type="email" required />
              </div>
            </div>
            <div className="grid grid-cols-2 gap-4">
              <div className="grid gap-2">
                <Label htmlFor="first-name">Labour Rate</Label>
                <Input id="first-name" type="text" required />
              </div>
              <div className="grid gap-2">
                <Label htmlFor="last-name">BestAuto Supplier</Label>
                <Input id="last-name" type="text" required />
              </div>
            </div>
            <Button type="submit" className="w-full">
              Register Your Shop
            </Button>
          </div>
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
