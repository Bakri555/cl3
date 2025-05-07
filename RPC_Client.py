import xmlrpc.client

n = int(input("Enter an integer value: "))

string1 = input("Enter first string: ")
string2 = input("Enter second string: ")

proxy = xmlrpc.client.ServerProxy('http://localhost:8000/')
result = proxy.factorial(n)
new_string = proxy.concat(string1, string2)

print(f"The factorial of {n} is {result}")
print(f"The concatination of two strings is {new_string}")

