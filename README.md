# Marcador de Truco

Aplicativo Android em Kotlin desenvolvido conforme as quatro questões de
`prints_codex/Avaliacao_2025_2 android.pdf`.

## Como executar

Abra esta pasta no Android Studio, sincronize o Gradle e execute o módulo
`app` em um emulador ou aparelho com Android 7.0 (API 24) ou superior.

## Funcionalidades

- Tela principal baseada no segundo modelo do PDF, com 4 TextViews e 12 botões.
- Pontuação independente para Nós e Eles: +1, +3, +6, +9 e +12.
- Ao atingir ou ultrapassar 12, um Toast informa a vitória, o contador do
  vencedor aumenta e os pontos de ambos os times voltam a zero.
- Histórico em uma segunda Activity com o total de vitórias por time.
- Zerar Histórico limpa pontos e vitórias e confirma a operação com Toast.
- O estado permanece ao navegar e ao girar a tela. Os contadores ficam em
  memória, com restauração por Bundle, sem armazenamento permanente.

## Referências utilizadas

- **CalculaIMC:** componentes XML, eventos de clique e mensagens Toast.
- **TipTime:** View Binding e preservação de estado com onSaveInstanceState.
- **TrocaTela:** navegação entre Activities e passagem de dados por Intent.

## Verificação

`gradlew.bat assembleDebug testDebugUnitTest lintDebug`

Os testes de Placar cobrem os incrementos, vitória exata e acima de 12,
contagem de múltiplas vitórias e reinicialização completa.

Com um emulador ou aparelho conectado, execute também
`gradlew.bat connectedDebugAndroidTest`. Os testes de interface verificam
pontuação, histórico, retorno, reinicialização e restauração da Activity.

O APK de desenvolvimento é gerado em `app/build/outputs/apk/debug/app-debug.apk`.
