package network

import java.io.EOFException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.ServerSocket
import java.net.Socket

fun <RQ, RS> listen(port: Int, connectionHandler: ConnectionHandler<RQ, RS>) {
    val serverSocket = ServerSocket(port)
    while (true) {
        val socket = serverSocket.accept()
        Thread {
            try {
                val inputStream = socket.getObjectInputStream()
                val outputStream = socket.getObjectOutputStream()
                while (true) {
                    val request = inputStream.readObject() as RQ
                    val response = connectionHandler.handle(request)
                    outputStream.writeObject(response)
                }
            } catch (_: EOFException) {
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }
}

private fun Socket.getObjectInputStream() = ObjectInputStream(this.getInputStream())

private fun Socket.getObjectOutputStream() = ObjectOutputStream(this.getOutputStream())