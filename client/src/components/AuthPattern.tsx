const AuthPattern = () => {
    return (
        <div className="grid grid-cols-3">
            {Array.from({ length: 9 }, (_, i) => (
                <div
                    key={i}
                    className="bg-green-600 animate-pulse h-24 rounded-2xl m-3"
                    style={{ animationDelay: `${i % 2 == 0 ? 0 : 1}s` }}
                />
            ))}
        </div>
    )
}

export default AuthPattern
