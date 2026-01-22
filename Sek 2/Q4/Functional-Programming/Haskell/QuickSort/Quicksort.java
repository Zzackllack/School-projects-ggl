public void quickSort(List<Integer> liste)
{
    if (laenge(liste) < 1){
        List<Integer> kleinere = new List<Integer>();
        List<Integer> groessere = new List<Integer>();
        liste.toFirst();
        int pivot = liste.getContent();
        liste.remove();
        while (!liste.isEmpty()){
            int akt = liste.getContent();
            if (akt < pivot){
                kleinere.append(akt);
            }
            else {
                groessere.append(akt);
            }
            liste.remove();
        }
        quickSort(kleinere); quickSort(groessere);
        liste.concat(kleinere);
        liste.append(pivot);
        liste.concat(groessere);
    }
}