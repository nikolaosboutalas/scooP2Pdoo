package network

interface ConnectionHandler<RQ, RS> {
    fun handle(request: RQ): RS
}