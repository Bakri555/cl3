import xmlrpc.server

def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)
    
def concat(string1, string2):
    return string1 + string2

server = xmlrpc.server.SimpleXMLRPCServer(('localhost', 8000))
server.register_function(factorial)
server.register_function(concat)
print("Server started on http://localhost:8000")
server.serve_forever()
