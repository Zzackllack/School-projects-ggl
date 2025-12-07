# Lösungen zu den Aufgaben

*b) Erläutern Sie, was die Methode scanne (zusammen mit der privaten Methode ausgabe) leistet.*

Die Methode `scanne` liest die Eingabezeichenkette Zeichen für Zeichen in Zweiergruppen ein, bis das Ende der Eingabe (markiert durch das Zeichen '#') erreicht ist. Für jede Zweiergruppe wird überprüft, ob sie einem der vordefinierten Token-Muster ("la", "le" oder "lu") entspricht. Wenn eine Übereinstimmung gefunden wird, wird ein entsprechendes Token-Objekt erstellt und zur Tokenliste hinzugefügt. Wenn keine Übereinstimmung gefunden wird, wird ein Fehlerzustand gesetzt und die Schleife abgebrochen. Am Ende der Methode wird die private Methode `ausgabe` aufgerufen, die überprüft, ob ein Fehler aufgetreten ist oder ob die Tokenliste leer ist, und entsprechend eine Erfolgsmeldung oder eine Fehlermeldung ausgibt.

*c) Erläutern Sie, was die Methode getTokenliste() leistet.*

Die Methode `getTokenliste()` gibt die Liste der erkannten Tokens zurück, sofern kein Fehler während des Scanvorgangs aufgetreten ist. Wenn der Scanvorgang erfolgreich war (d.h., `istFehler` ist `false`), wird die Tokenliste zurückgegeben. Andernfalls, wenn ein Fehler festgestellt wurde, gibt die Methode `null` zurück. Dies ermöglicht es dem Aufrufer, zu überprüfen, ob der Scanvorgang erfolgreich war und gegebenenfalls auf die erkannte Tokenliste zuzugreifen.
