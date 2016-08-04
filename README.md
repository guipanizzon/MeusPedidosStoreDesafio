
<h1>Informações do Desafio:</h1>

*  <h1>Bibliotecas Utilizadas</h1>
    * Google Gson
        https://github.com/google/gson
    * Google Volley 
        https://android.googlesource.com/platform/frameworks/volley/
    * Google Android Support Library package
        *   Appcompat library v7:24.1.1
        *   Android Design Support Library 24.1.1
        *   Android Test Support Library - Espresso (spresso-core:2.2.2)
        *   RecyclerView Support Library - v7:24.1.1'
        *   CardView Support Library - v7: 24.1.1

* O .apk chama-se meuspedidosStore e encontra-se na raiz do projeto.

*  Pontos observados no desenvolvimento do projeto:
    *  A maioria dos componentes necessitavam de adaptações. Tornando-se literalmente um desafio a busca de métodos e funções que garantissem a maior compatibilidade possível.
    *  Foi escolhida como minSdkVersion a API 12 pelo fato que dispositivos com a API>=12 representam cerca de 97.4% dos aparelhos utilizados na Play Store. Já o targetSdkVersion=24 e a versão do compileSdkVersion=24.
    *  Foi escolhido utilizar o Volley para ocache do JSON e imagens por aceitar algumas costumizações mais avançadas.No início surgiu a ideia de usar o Picasso. Contudo, no Volley é possível costumizar a camada de transporte, na qual poderíamos estar utilizado a biblioteca OkHttp().
    
*  Mockups da MeusPedidosStore

<p align="center">
  <img src="https://drive.google.com/open?id=0B7FmV_naE3EkT093YWNuZlc5RDg" width="350"/>

</p>
   

