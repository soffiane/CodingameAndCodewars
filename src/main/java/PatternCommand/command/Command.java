package PatternCommand.command;

/**
 * On cr�e l'interface Command qui sera impl�ment�e pour chaque nouvelle commande
 * @author soffiane
 *
 */
@FunctionalInterface
public interface Command {
	void execute();
}
