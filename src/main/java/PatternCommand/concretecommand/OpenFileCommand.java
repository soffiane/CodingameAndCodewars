package PatternCommand.concretecommand;

import PatternCommand.command.Command;
import PatternCommand.receiver.FileSystemReceiver;

/**
 * Commande permettant d'ouvrir un fichier
 * @author soffiane
 *
 */
public class OpenFileCommand implements Command {

	private FileSystemReceiver fileSystem;
	
	public OpenFileCommand(FileSystemReceiver fs){
		this.fileSystem=fs;
	}
	
	public void execute() {
		//open command is forwarding request to openFile method
		this.fileSystem.openFile();
	}

}
