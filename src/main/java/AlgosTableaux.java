import java.util.Scanner;
//Pas fini désolé 
public class AlgosTableaux {
    /**
     * Demande à l'utilisateur de saisir un entier, jusqu'à ce que
     * l'entier saisi soit entre les deux bornes en paramètres.
     *
     * @param pfBorneInf IN : borne inférieure
     * @param pfBorneSup IN : borne supérieure
     *
     * @return un entier entre pfBorneInf et pfBorneSup, compris
     */
    public static int saisieIntC (int pfBorneInf, int pfBorneSup){
        int valeur;
        Scanner clavier = new Scanner(System.in) ;
        System.out.println("Donnez une valeur comprise entre "+pfBorneInf+" et "+pfBorneSup+ "?");
        valeur = clavier.nextInt();
        while (valeur<pfBorneInf || valeur>pfBorneSup){
            System.out.println("Erreur ! Donnez une valeur comprise entre "+pfBorneInf+" et "+pfBorneSup+ "?");
            valeur = clavier.nextInt();
        }
        return valeur;
    }

    /**
     * Demande à l'utilisateur :
     *   1. de saisir le nombre de cases qu'il souhaite remplir, et
     *      répète l'opération, jusqu'à ce que ce nombre soit
     *      acceptable
     *   2. de remplir les cases une à une.
     *
     * @param pfTab OUT : tableau à remplir
     *
     * @return le nombre de cases remplies dans le tableau
     */
    public static int saisirTableau (int[] pfTab){
        int nbEl = 0 ;
        System.out.println("Combien de valeur voulez-vous remplir ?");
        nbEl=saisieIntC(1,pfTab.length);
        for (int i=0 ; i<nbEl; i++){
            System.out.println("Remplir la valeur n°"+ (i+1));
            pfTab[i]=saisieIntC(-100,100);
        }    
        System.out.println("J'avais " + pfTab.length
            + " cases disponibles, et j'en ai rempli "+ nbEl);
        return nbEl ;
    }

    /**
     * Affiche le tableau en paramètre.
     *
     * @param pfTab IN : tableau
     * @param pfNbEl IN : nombre de cases remplies dans le tableau
     *
     */
    public static void afficherTableau(int[] pfTab, int pfNbEl) {
        for (int i=0; i< pfNbEl;i++){
            System.out.println(pfTab[i]+" est la "+(i+1)+" valeur");
        }
    }

    /*
     * Programme servant à tester les différentes fonctions qu'on a créé. 
     * 
     */
    public static void main(String [] args){
        /* Declaration des variables */
        int nbVal ; //nombre de valeurs a traiter
        int tab[]  ; // tableau permettant de stocker les valeurs

        tab = new int[100] ;

        // Ajouter les appels aux algorithmes :
        nbVal=saisirTableau(tab);
        afficherTableau(tab,nbVal);
        inverserTableau(tab,nbVal);
        System.out.println("----------------");
        afficherTableau(tab,nbVal);
        System.out.println("----------------");
        eliminerDoublons(tab,nbVal);
    }

    /**
     * Prend un tableau et renvoie le même tableau inversé.     *
     * @param pfTab IN : tableau
     * @param pfNbEl IN: nombre d'élément dans le tableau 
     *
     */
    public static void inverserTableau (int[] pfTab,int pfNbEl){
        int temp;
        for (int i=0; i<=pfNbEl/2; i++){
            temp=pfTab[i];
            pfTab[i]=pfTab[pfNbEl-i-1];
            pfTab[pfNbEl-i-1]=temp;
        }
    }

    /**
     * Prend un talbeau avec pfNbEl élément de rempli et 
     * @param pfTab IN : tableau
     * @param pfNbEl IN: nombre d'élément dans le tableau 
     * @return Le même tableau sans doublons. 
     */
    public static void eliminerDoublons (int[] pfTab,int pfNbEl){
        int ntab[]  ; // tableau permettant de stocker les valeurs
        ntab = new int[pfNbEl] ;
        ntab[0]=pfTab[0];
        boolean existe=false;
        int taille=1;
        for (int i=1;i<pfNbEl;i++){
            existe=false;
            for (int j=0;j<taille;j++){
                if (pfTab[i]==ntab[j]){
                    existe=true;            
                }
            }    
            if (existe==false){
                ntab[taille]=pfTab[i];
                taille=taille+1;
            }
        }
        afficherTableau(ntab,taille);    
    }
}