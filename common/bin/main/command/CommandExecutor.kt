package command

interface CommandExecutor {
    fun canExecute(command: Command): Boolean

    fun execute(command: Command): CommandOutput
}