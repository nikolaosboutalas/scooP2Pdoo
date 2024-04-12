package command

import java.io.Serializable

data class CommandOutput(
    val content: Any,
    val type: Type
) : Serializable {
    enum class Type {
        MESSAGE,
        FILE,
        ERROR
    }
}
