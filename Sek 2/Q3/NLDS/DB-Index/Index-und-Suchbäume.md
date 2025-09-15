# Datenbank-Index und Suchbäume

*Aufgabe 1: Recherchieren Sie, was ein Datenbank-Index ist und welche Verbindung zum Thema Suchbäume besteht. Schreiben Sie einen kurzen (ca. 7-10 Sätze) Text dazu.*

Ein Datenbank-Index ist eine Datenstruktur, die das Finden von Datensätzen beschleunigt, damit nicht die gesamte Tabelle gescannt werden muss. Er funktioniert ähnlich wie ein Buchindex mit Verweisen auf die Positionen der Daten. Häufig werden Suchbäume wie B-Bäume (B-tree) oder B+-Bäume als Indexstruktur verwendet, weil sie ausgeglichen sind und schnelle Suche, Einfügen und Löschen ermöglichen. Das spart Zeit bei großen Datenmengen, insbesondere bei SELECT-Abfragen mit WHERE- oder JOIN-Bedingungen. Indizes können für eine oder mehrere Spalten angelegt werden und reduzieren die Antwortzeit von Abfragen, benötigen aber zusätzlichen Speicherplatz und verursachen Overhead beim Einfügen, Aktualisieren und Löschen. In-Memory-Systeme wie Redis nutzen oft andere Strukturen (Hash-Tabellen, Skip-Listen) und setzen weniger auf klassische B-Bäume. Relationale Datenbanken hingegen verwenden in der Regel B-Bäume als Standard-Index und sind dadurch für viele OLTP-Szenarien optimiert.

Beispiele in SQL:

- Einfacher Index:

```sql
CREATE INDEX idx_person_name ON person(name);
```

- Zusammengesetzter (komposit) Index:

```sql
CREATE INDEX idx_orders_customer_date ON orders(customer_id, order_date);
```

- Einzigartiger Index:

```sql
CREATE UNIQUE INDEX ux_user_email ON users(email);
```

- Index entfernen (PostgreSQL / MySQL Unterschiede):

```sql
-- PostgreSQL
DROP INDEX idx_person_name;

-- MySQL
DROP INDEX idx_person_name ON person;
```

- Prüfen, ob und wie ein Index genutzt wird:

```sql
EXPLAIN SELECT * FROM orders WHERE customer_id = 42;
```
