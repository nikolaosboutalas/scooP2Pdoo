package command

import command.CommandOutput.Type.ERROR
import network.ConnectionHandler

class CommandBus(private vararg val commandExecutors: CommandExecutor) : ConnectionHandler<Command, CommandOutput> {
    override fun handle(request: Command) =
        commandExecutors.find { it.canExecute(request) }?.execute(request)
            ?: CommandOutput("Command ${request.name} not supported", ERROR)
}
