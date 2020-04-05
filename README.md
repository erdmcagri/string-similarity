# String Similarity

**Amaç**
Girilen iki String ifadenin birbirinin permütasyonları olup olmadığına karar verilmesidir. 
Örneğin;

_"baba"_ , _"abab"_ -> _true_
_"baba"_ , _"abc"_ -> _false_

Girilen stringler karakterlerine ayrılarak karakter bazlı bir karşılaştırma yapıldı. Girilen stringlerden karakter olarak daha fazla karaktere sahip stringin karakter sayısı az olan stringle 

Uzunluğu fazla olan string ifadenin diğer string ifade ile karakterleri karşılaştırılarak,  aralarındaki benzerlik % 70 den ise bu stringler birbirinin permutasyonu olabilir kabul edilmiştir.
