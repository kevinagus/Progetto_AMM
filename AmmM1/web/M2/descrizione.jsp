<%-- 
    Document   : descrizione
    Created on : 29-apr-2017, 22.45.43
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="it-IT">
    <head>
        <title>Nerdbook</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Agus Kevin">
        <meta name="keywords" content="conosci,trova e chatta con i tuoi amici nerd">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        
        <c:set var="titolo" value="Nerdbook" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <c:set var="page" value="descrizione" scope="request"/>
        <jsp:include page="nav.jsp"/>
        
        <div id="divSom">
            <h2>Indice</h2>
            <ul>
                <li><a href="#descrizione">Descrizione</a></li>
                <li><a href="#history">Rete sociale</a></li>
                <li><a href="#classifica">Classifica social</a></li>
                <li><a href="#fb">Facebook</a></li>
                <li><a href="#controind">Controindicazioni</a></li>
            </ul>
        </div>
        
        <div id="focus">
            <div>
                <a id="descrizione"></a>
                <h2>Descrizione</h2>
                <p>
                    Nerdbook è un social network semplificato, che permetta agli utenti di stringere amicizie e di creare e gestire dei gruppi. Si avranno due tipologie di utenti:
                    Utenti registrati, che possono inserire informazioni personali, stringere amicizia con altri utenti, creare e gestire dei gruppi, inserire post nella sua bacheca o quella degli amici.
                    Nerdbook è un social interamente gratuito, chiunque con almeno 16 anni di et&agrave; può iscriversi e iniziare subito questa esperienza.
                </p>
            </div>
            <div>
                <h3>Profilo utente</h3>
                <p>
                    Un utente registrato ha associati una serie di dati personali (nome, cognome, data di nascita). Inoltre ha una frase di presentazione che appare in cima alla propria bacheca ed una immagine del profilo, di cui specifica la URL. Inoltre, ha una password che può modificare. 
                    Ogni utente registrato ha una bacheca, che mostra una serie di post.
                </p>
            </div>
            <div>
                <h3>Post</h3>
                <p>
                    I post sono formati da: un messaggio,un allegato opzionale, che può essere un link o una immagine, entrambi da specificare come URL. 
                    Un utente registrato può inserire dei post nella sua bacheca o in quella dei suoi amici. Nel caso un utente visiti la bacheca di un altro utente che non è nella lista dei suoi amici, l’applicazione gli permetterà di stringere amicizia.
                    Una volta stretta l’amicizia, l’utente potrà inserire dei post in bacheca. 
                </p>
            </div>
            <div>
                <h3>Gruppi</h3>
                <p>
                    I gruppi permettono di raccogliere degli utenti, che non siano necessariamente amici fra loro, per condividere informazioni e materiali legati da un comune interesse. Anche i gruppi hanno la loro bacheca. Ogni volta che un post viene pubblicato sulla bacheca di un gruppo, questo viene replicato anche nella bacheca di tutti gli appartenenti al gruppo.
                    Un utente si iscrive spontaneamente visitando la bacheca del gruppo e richiedendo l’iscrizione. Non è prevista la conferma dell’iscrizione dagli altri appartenenti al gruppo. 
                    Il gruppo viene fondato da un utente, che è l’unico, oltre all’amministratore, che può cancellarlo. Una volta cancellato, anche tutti i post del gruppo sono eliminati.
                    L’amministratore, che può cancellare i post da qualsiasi bacheca e cancellare qualsiasi gruppo.
                </p>
            </div>
            <div>
                <a id="history"></a>
                <h2>Rete sociale</h2>
                <p>
                    Una rete sociale (in lingua inglese social network) consiste in un qualsiasi gruppo di individui connessi tra loro da diversi legami sociali. Per gli esseri umani i legami vanno dalla conoscenza casuale, ai rapporti di lavoro, ai vincoli familiari. Le reti sociali sono spesso usate come base di studi interculturali in sociologia, in antropologia, in etologia.
                    L'analisi delle reti sociali, ovvero la mappatura e la misurazione delle reti sociali, può essere condotta con un formalismo matematico usando la teoria dei grafi. In generale, il corpus teorico ed i modelli usati per lo studio delle reti sociali sono compresi nella cosiddetta social network analysis.
                    La ricerca condotta nell'ambito di diversi approcci disciplinari ha evidenziato come le reti sociali operino a più livelli (dalle famiglie alle comunità nazionali) e svolgano un ruolo cruciale nel determinare le modalità di risoluzione di problemi e i sistemi di gestione delle organizzazioni, nonché le possibilità dei singoli individui di raggiungere i propri obiettivi.
                </p>
            </div>
            <div>
                <a id="classifica"></a>
                <h2>I social più utilizzati</h2>
                <p>
                    Qual è stato il social network più utilizzato nel mondo durante il 2016? Facebook, e fin qui non è certo una notizia.Sorprende invece l'ascesa di Instagram, che insidia Tumblr, non così intuitivo per tutti. Mentre è stabile sul podio LinkedIn, il raccoglitore online di curricula. Ma scopriamo la top ten completa.
                    Flickr in discesa, VK cosa?
                    10) Vine - Specializzato nella pubblicazione di video, condivisibili sulla maggior parte dei social, lo usano 40 milioni di utenti.
                    9) Flickr - Al mese attira 65 milioni di visitatori, ma qualche anno fa erano il doppio. Nato come vetrina fotografica, oggi è nettamente superato dai vari Facebook e Instagram.
                    8) VK - Va fortissimo nell'Europa dell'Est (80 milioni di visitatori mensili in Russia e Ucraina), in Italia invece non sanno nemmeno cosa sia. In pratica è una sorta di Facebook: "VK" sta per "VKontakte", che significa "in contatto".
                    7) Instagram - Il più utilizzato dai vip. Oltre 100 milioni di utenti registrati, che postano immagini e selfie a manetta, modificandoli con le nuove opzioni di fotoritocco. Pensate che in America c'è chi chiama il proprio figlio con il nome dei filtri...
                    6) Tumblr - Crea blog e contenuti multimediali. Con circa 110 milioni di utenti, resta una delle piattaforme più frequentate, ma non ha ancora quell'appeal puramente social tale da scomodare colossi come Facebook o Twitter.
                    Google Plus si fa largo, Pinterest di nicchia ma non troppo
                    5) Google Plus - E' la parte 2.0 di Google che, oltre a essere il motore di ricerca più consultato del web, vuole farsi spazio anche nel mondo dei social. Lo usano al mese 120 milioni di registrati, in Italia sono quasi 4 milioni.
                    4) Pinterest - Cataloga immagini e video, di qualunque genere o argomento. Un social di nicchia, che poi tanto di nicchia non è: i visitatori sono oltre 250 milioni.
                    3) LinkedIn - L'iscrizione è gratuita, idem l'utilizzo, a meno che non si voglia usufruire delle opzioni supplementari, che sono a pagamento. Ideale per chi fa ricerca e selezione del personale, ben 255 milioni, di cui 7 milioni in Italia, lo considerano un ottimo strumento per candidarsi presso aziende o datori di lavoro.
                    2) Twitter - Con i suoi 140 caratteri (anche se sembra che presto i messaggi diventeranno più lunghi), è il social più usato dalle istituzioni. Gli iscritti sono circa 330 milioni al mese, in Italia 8 milioni.
                    1) Facebook - Oltre un miliardo di visitatori mensili, 28 milioni in Italia. E' il padre dei social. E difficilmente verrà deposto dai suoi figli. O comunque non certo nel 2017.
                </p>
            </div>
            <div>
                <a id="fb"></a>
                <h3>Facebook</h3>
                <p>
                    Facebook è un servizio di rete sociale lanciato il 4 febbraio 2004, posseduto e gestito dalla società Facebook Inc., basato su una piattaforma software scritta in vari linguaggi di programmazione. Il sito, fondato ad Harvard negli Stati Uniti da Mark Zuckerberg, Eduardo Saverin, Andrew McCollum, Dustin Moskovitz e Chris Hughes, era originariamente stato progettato esclusivamente per gli studenti dell'Università di Harvard, ma fu presto aperto anche agli studenti di altre scuole della zona di Boston, della Ivy League e della Stanford University.
                    Successivamente fu aperto anche agli studenti delle scuole superiori e poi a chiunque dichiarasse di avere più di 13 anni di età. Da allora Facebook raggiunse un enorme successo: secondo Alexa è il terzo sito più visitato al mondo dopo Google e YouTube.Ha cambiato profondamente molti aspetti legati alla socializzazione e all'interazione tra individui, sia sul piano privato che quello economico e commerciale.
                    È disponibile in oltre 100 lingue (in italiano dal 14 maggio 2008) e a luglio 2016 contava circa 1,7 miliardi di utenti attivi mensilmente, classificandosi come primo servizio di rete sociale per numero di utenti attivi.
                    Il nome "Facebook" prende spunto da un elenco con nome e fotografia degli studenti, che alcune università statunitensi distribuiscono all'inizio dell'anno accademico per aiutare gli iscritti a socializzare tra loro.
                    Gli utenti possono accedere al servizio previa una registrazione gratuita, durante la quale vengono richiesti dati personali come nome, cognome, data di nascita e indirizzo email. Il sito web chiarisce che l'inserimento obbligatorio della data di nascita serve esclusivamente "per favorire una maggiore autenticità e consentire l'accesso ai vari contenuti in base all'età". Completata la registrazione, gli utenti possono creare un profilo personale, includere altri utenti nella propria rete sociale, aggiungendoli come "amici", e scambiarsi messaggi, anche via chat, incluse le notifiche automatiche quando questi aggiornano i propri profili. Per personalizzare il proprio profilo l'utente può caricare una foto, chiamata immagine del profilo, con la quale può rendersi riconoscibile. Può inoltre fornire ulteriori informazioni, come il comune di nascita e quello di residenza, la scuola frequentata, il proprio datore di lavoro, l'orientamento religioso e quello politico, la propria situazione sentimentale e molte altre.
                    Inoltre gli utenti possono fondare e unirsi a gruppi per condividere interessi in comune con altri utenti, organizzati secondo il luogo di lavoro, la scuola, l'università o altre caratteristiche, condividere contenuti multimediali ed utilizzare varie applicazioni presenti sul sito.
                    Recentemente milioni di utenti usano Facebook come una piattaforma simile a quella di YouTube ovvero, mettere in mostra i propri video, creando un pubblico numeroso.
                    Facebook non è solo per le persone fisiche e la loro vita privata ma, attraverso un servizio dedicato (Facebook for Business), è anche un strumento di social marketing.
                </p>
            </div>
            <div>
                <a id="controind"></a>
                <h2>Controindicazioni</h2>
                <p>
                    Quando si parla di social network si tende sempre a enfatizzarne gli aspetti positivi. In realtà, le reti sociali sono un vincolo, in quanto obbligano i soggetti ad adattarsi alle caratteristiche degli strumenti utilizzati.
                    Da una parte, il corpo reale con le sue emozioni scompare dalla relazione. Viene sostituito da un corpo virtuale formato da una pluralità di immagini parziali e contestualizzate che mostrano soltanto quegli aspetti che vogliamo condividere e sottolineare. Questo processo ha come possibile effetto l’analfabetismo emotivo: l’incapacità di riconoscere le emozioni proprie o altrui. Per esempio, lasciare il proprio ragazzo semplicemente cambiando il proprio status su Facebook da «fidanzata» a «single» è molto diverso che dirgli «ti voglio lasciare» guardandolo negli occhi. Se nel secondo caso, osservare la risposta emotiva dell’ex ci costringe a condividere la sua sofferenza spingendoci a moderare le parole e i gesti, usando il social network l’altro e le sue emozioni non sono immediatamente visibili e non hanno quindi un impatto diretto sulle nostre decisioni. Ciò priva il soggetto di un importante punto di riferimento nel processo di apprendimento e comprensione delle emozioni proprie e altrui con effetti che vanno dal disinteresse emotivo alla psicopatia.
                    Allo stesso tempo, questo corpo virtuale, insieme alle storie raccontate da noi e dai nostri amici nei social network, assume vita propria rimanendo presente e visibile anche quando noi non lo vogliamo. Questa possibilità produce il primo dei paradossi dei social network: se io posso più facilmente cambiare la mia identità è vero che anche l’intervento esterno può modificare più facilmente il modo in cui gli altri percepiscono la mia identità. Per esempio, un singolo commento negativo di un amico può avere un impatto rilevante sul modo con cui gli altri membri della rete mi percepiscono. Il risultato è un’«identità fluida», che è allo stesso tempo flessibile ma precaria, mutevole ma incerta. Se un’identità fluida può essere un vantaggio per un adulto, può diventare un problema per un adolescente che sta cercando di costruire la propria identità. In particolare può portare a un rallentamento del processo di costruzione dell’identità e a sostituire la stabilità e il futuro con un eterno presente privo di certezze e di legami.
                    Un ulteriore problema – non solo per gli adolescenti ma anche per gli adulti – è la grande quantità di dati e informazioni personali presenti nei social network. Tali informazioni sono alla base del secondo paradosso dei social network: se nei social network posso più facilmente cambiare la mia identità virtuale è vero anche che, seguendo le tracce lasciate dalle diverse identità virtuali, è più facile per altri ricostruire la nostra identità reale. Infatti, le tracce delle diverse identità creano una memoria storica della propria attività e personalità che non scompare anche quando il soggetto lo vorrebbe. Tale memoria storica può essere utilizzata da altri a scopi professionali – per esempio, per valutare un candidato in un colloquio di lavoro – o fraudolenti, per esempio per assumere la personalità di un altro, come avviene nel furto d’identità (identity theft).
                    Infine, anche il successo dei social network nasconde un’insidia: gestire il proprio profilo su un social network richiede all’utente tempo e capacità di gestione non banali che possono avere un impatto rilevante sull’attività lavorativa o di studio. Se un uso moderato dei social media inferiore al 20% del tempo lavorativo (circa due ore al giorno) può produrre un aumento di produttività, il superamento di questa soglia può nascondere un vero proprio «disturbo di dipendenza da Internet» che ha un impatto significativo sulla produttività individuale e sulla dimensione relazionale.
                    In conclusione i social network, come tante altre cose nella nostra vita quotidiana, hanno due facce: una buona e una cattiva. Se usati da persone mature in modo responsabile sono un’importante opportunità per raccontarsi, per migliorare le proprie relazioni interpersonali e perfino per fare business. Al contrario, se usati in maniera non responsabile da persone troppo giovani possono creare problemi e difficoltà che in alcuni casi nemmeno il tempo riesce a cancellare.
                </p>
            </div>
        </div>
    </body>
</html>
