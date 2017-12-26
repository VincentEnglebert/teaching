* Exercice: 'Workflow' 

Let a workflow described hereafter:

The CHECK task receives documents and verifies their conformity. If the document is in conformity, it is entrusted to the
DISPATCH task, if not the TRASH task. The DISPATCH task sends the document to the BILL, SEND or
ORDER as indicated in the document in the STATUS field (exclusive choice). The ORDER task
sends a document to SEND and BILL for each document received. When these two tasks have been completed, the BAKCUP task
process the both related documents, and writes in a file that a document has been processed.

