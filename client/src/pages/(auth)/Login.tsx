import { useState } from "react"
import { Eye, EyeOff } from 'lucide-react'
import { Link } from "react-router-dom";
import AuthPattern from "../../components/authPattern";
const Login = () => {
    const [eye, setEye] = useState(false);

    const handleEye = () => {
        setEye(prev => !prev)
    }
    return (
        <div className='flex items-center justify-center h-screen bg-gray-200'>
            <div className=" border-2 border-gray-600 rounded-2xl min-w-4xl flex h-96">
                <div className="flex-1 border-r-2 border-gray-600">
                    <h1 className="font-bold text-2xl text-center py-8 ">
                        Login Page
                    </h1>
                    <div className="px-4">


                        <div className="flex flex-col pl-4 pb-2">
                            <label htmlFor="username" className="font-semibold text-md pb-2">Email</label>
                            <input
                                type="text"
                                placeholder="Email"
                                name="email"
                                className="border-2 rounded-xl pl-4 py-2 border-gray-600"
                            />
                        </div>
                        <div className="flex flex-col pl-4 pb-2">
                            <label htmlFor="username" className="font-semibold text-md pb-2">Password</label>
                            <div className="relative">

                                <input
                                    type={eye ? "text" : "password"}
                                    placeholder="***********"
                                    name="password"
                                    className="border-2 rounded-xl pl-4 py-2 w-full border-gray-600"
                                />
                                {eye ?
                                    <Eye
                                        onClick={handleEye}
                                        className="absolute  right-2 top-2"
                                    /> :
                                    <EyeOff
                                        onClick={handleEye}
                                        className="absolute  right-2 top-2"
                                    />}
                            </div>
                        </div>
                        <div>
                            <div className="text-right text-sm pb-2 text-green-700">
                                forgot password ?
                            </div>
                        </div>
                        <div className="pl-4 pb-2">
                            <button
                                className="text-white bg-green-700 hover:bg-green-600 w-full py-2 rounded-2xl active:bg-green-800"
                            >
                                Submit
                            </button>
                        </div>
                    </div>

                    <div className="text-center">
                        <Link to="/signup" className="text-sm hover:underline "  >
                            Create an Account ? <span className="text-green-700 hover:text-green-800 font-bold">
                                Signup
                            </span>
                        </Link>
                    </div>
                </div>
                <div className="flex-1">
<AuthPattern />
                </div>
            </div>
        </div>
    )
}

export default Login
