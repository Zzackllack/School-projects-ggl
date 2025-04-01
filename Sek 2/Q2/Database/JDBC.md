**Was ist JDBC?**

JDBC (Java Database Connectivity) ist eine Programmierschnittstelle (API) in der Programmiersprache Java, die es Java-Anwendungen ermöglicht, auf relationale Datenbanken zuzugreifen und mit ihnen zu interagieren. Sie stellt Methoden zur Verfügung, um SQL-Anweisungen zu senden, Ergebnisse zu verarbeiten und Datenbankverbindungen zu verwalten. JDBC ist Bestandteil der Java Standard Edition (Java SE).

**Wie verhält sich JDBC in Bezug auf unterschiedliche Datenbanken (Derby, Oracle, MySQL, ...)?**

JDBC ist so konzipiert, dass es mit verschiedenen relationalen Datenbanken kompatibel ist, darunter Apache Derby, Oracle, MySQL, PostgreSQL und viele andere. Damit JDBC mit einer bestimmten Datenbank funktioniert, wird ein spezifischer JDBC-Treiber benötigt, der die Kommunikation zwischen der Java-Anwendung und der jeweiligen Datenbank ermöglicht. Diese Treiber implementieren das JDBC-Interface und sind in der Regel vom jeweiligen Datenbankanbieter oder Drittanbietern bereitgestellt.

Es gibt vier Typen von JDBC-Treibern:

- **Typ-1:** JDBC-ODBC-Bridge (veraltet und selten verwendet)
- **Typ-2:** Native-API-Treiber (benötigt native Bibliotheken)
- **Typ-3:** Netzwerkprotokoll-Treiber (verwendet Middleware)
- **Typ-4:** Reiner Java-Treiber (direkte Kommunikation über das Datenbankprotokoll, am häufigsten verwendet)

**Was ermöglicht JDBC?**

JDBC ermöglicht Java-Programmen:

- Verbindungen zu relationalen Datenbanken herzustellen
- SQL-Befehle wie SELECT, INSERT, UPDATE und DELETE auszuführen
- Ergebnisse von SQL-Abfragen auszulesen und zu verarbeiten
- Datenbankverbindungen sicher zu verwalten und zu schließen
- Transaktionen zu verwalten (Commit und Rollback)

Durch die Standardisierung über JDBC können Entwickler Java-Anwendungen schreiben, die mit verschiedenen Datenbanken funktionieren, indem sie lediglich den entsprechenden JDBC-Treiber austauschen, ohne den restlichen Anwendungscode wesentlich ändern zu müssen.

**Was ist Derby?**

Apache Derby ist eine relationale Datenbank, die vollständig in Java implementiert ist und somit plattformunabhängig läuft. Sie kann sowohl als eingebettete Datenbank direkt in Java-Anwendungen integriert werden, als auch im Client-Server-Modus betrieben werden, und eignet sich besonders gut für Entwicklungs-, Test- und Lernumgebungen aufgrund ihrer einfachen Verwendbarkeit und geringen Ressourcenanforderungen.