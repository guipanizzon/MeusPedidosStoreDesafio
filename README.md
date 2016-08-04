
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
  <img src="https://d17oy1vhnax1f7.cloudfront.net/items/3D320j1o3t3r1P2n1c3S/Screenshot_20160804-103049.png" width="150"/>
    <img src="https://d17oy1vhnax1f7.cloudfront.net/items/090q3R1Z062Z1l2a3K18/Screenshot_20160804-103101.png" width="150"/>
    <img src="https://d17oy1vhnax1f7.cloudfront.net/items/0L403R2x420a0N1J2U3x/Screenshot_20160804-103110.png" width="150"/>
   <img src="https://d17oy1vhnax1f7.cloudfront.net/items/0t0X3h1J0u1r2F290J1E/Screenshot_20160804-103648.png"  width="150"/>
</p>
   

