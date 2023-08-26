select st.SupplierTransactionID, s.SupplierID,
		s.SupplierName, st.TransactionDate, st.TransactionAmount
from SupplierTransactions st, Suppliers s
where (st.SupplierID = s.SupplierID) 
and st.TransactionDate between '2013-02-01' and '2013-02-15'