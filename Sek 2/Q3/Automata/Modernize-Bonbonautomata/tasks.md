# Bonbonautomat Modernisieren

Der Kellerautomat kann aufgrund seines Speichers Wörter mit einer komplexeren Struktur erkennen als ein deterministischer endlicher Automat. So ist die Fähigkeit passende Klammerpaare erkennen zu können von großer Bedeutung, um mathematische Terme zu analysieren. Doch auch dem Kellerautomaten sind Grenzen gesetzt. Zwar kann der Kellerautomat für Wörter der Form a^n b^n sich die Anzahl der a merken, aber für Wörter, für der der Automat sich die gleiche Anzahl drei verschiedener Buchstaben (a, b, c) merken müsste, würde der Kellerspeicher nicht genügen. Ein Kellerautomat kann zwar die Anzahl der a speichern und sie mit den folgenden b vergleichen, aber die Anzahl der a steht für weitere Berechnungen nicht mehr zu Verfügung, da der Keller geleert wurde. Sprachen der Form L = {a^n b^n c^n | n > 0} können von einem Kellerautomaten nicht erkannt werden. Um das zu bewerkstelligen, müsste man die Einschränkungen des Kellerautomaten aufheben. Das Modell müsste es erlauben, sich auf der Eingabe in beide Richtungen zu bewegen und der Zugriff auf den Speicher dürfte sich nicht nur auf das oberste Element beschränken.

### Aufgaben

1. Der Bonbon-Automat wird durch eine moderne Version ersetzt. Bei dieser gibt es zwei unterschiedliche Bonbons (süß und sauer), die jeweils 20 Cent kosten. Eingeworfen werden können 10-und 20-Cent-Münzen. Das süße Bonbon wählt man über ein Rechtsdrehen des Hebels, das saure über ein Linksdrehen.
    - a) Entwickeln Sie einen Mealy-Automaten mit tabellarischer Übergangsfunktion für den modernen Bonbonautomaten.
    - b) Zeichnen Sie den Überführungsgraphen des Mealy-Automater aus a).

2. Geben Sie an, welche der folgenden Mengen gültige Alphabete für endliche Automaten sind. Erläutern Sie Ihre Antwort.
    - a) N_ung = {1,3,5,7,...}
    - b) {∅}
    - с) {1,3,A,B,±}
    - d) {π, e, -1}

3. Geben Sie zu den aufgeführten Symbolfolgen ein Alphabet Σ an.
    - a) a,b,c
    - b) AabBabB
    - c) aaaaa
    - d) (a+b)*2
    - e) 010001101
    - f) I, II, III, IV, V, VI, VII, VIII, IX, X
    - g) 1024
