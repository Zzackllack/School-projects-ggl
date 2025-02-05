public class InsertionSort {
    public void insertionSort(){
        List <Integer> sortiereListe = new List<Integer>();
        while (!List.isEmpty()){
            List.toFirst();
            int elToInsert = List.getContent();
            sortiereListe.toFirst();
            while (sortiereListe.hasAccess() && sortiereListe.getContent() < elToInsert){
                sortiereListe.next();
            }
            if (sortiereListe.hasAccess()){
                sortiereListe.insert(elToInsert);
            } else {
                sortiereListe.append(elToInsert);
            }
            List.remove();
        }
        List = sortiereListe;
    }
}
