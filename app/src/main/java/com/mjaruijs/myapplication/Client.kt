package com.mjaruijs.myapplication

import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.SocketChannel

class Client(private val channel: SocketChannel) {

    constructor(address: String, port: Int) : this(SocketChannel.open(InetSocketAddress(address, port)))

    private fun write(bytes: ByteArray) {
        val buffer = ByteBuffer.allocate(bytes.size + 4)
        buffer.putInt(bytes.size)
        buffer.put(bytes)
        buffer.rewind()

        channel.write(buffer)
    }

    fun write(string: String) = write(string.toByteArray())

    fun close() {
        channel.close()
    }

}