# DB-Wiederholung Arbeitsauftrag 3 : Seite 1

a)

```sql
SELECT PersNr, Name, Vorname, Beruf, Gehalt, AbtNr, ProjektNr FROM Mitarbeiter WHERE AbtNr=20 ORDER BY Name
```

b)

```sql
SELECT AVG(Gehalt) FROM Mitarbeiter
```

c)

```sql
SELECT AbtNr, MAX(Gehalt) AS Hoechstgehalt FROM Mitarbeiter GROUP BY AbtNr;
```

d)

```sql
SELECT p.ProjektName, m.Name, m.PersNr FROM Projekt p JOIN Mitarbeiter m ON p.ProjektNr = m.ProjektNr;
````
