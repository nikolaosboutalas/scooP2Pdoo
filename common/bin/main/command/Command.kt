package command

import java.io.Serializable

data class Command(
    val name: Name,
    val input: String
) : Serializable {
    enum class Name {
    }
}
