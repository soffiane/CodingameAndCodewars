package PatternCommand.concretecommand;

import PatternCommand.command.Command;
import PatternCommand.receiver.FileSystemReceiver;

/**
 * Commande pour ecrire dans un fichier
 * @author soffiane
 *
 */
public class WriteFileCommand implements Command {

	private FileSystemReceiver fileSystem;
	
	public WriteFileCommand(FileSystemReceiver fs){
		this.fileSystem=fs;
	}
	
	public void execute() {
		this.fileSystem.writeFile();
	}

}
