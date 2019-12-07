package PatternCommand.receiver;

/**
 * Objet receiver : interface avec les methodes possibles
 * @author soffiane
 *
 */
public interface FileSystemReceiver {

	void openFile();
	void writeFile();
	void closeFile();
}
