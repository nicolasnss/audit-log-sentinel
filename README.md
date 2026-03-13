\# Audit-Log Sentinel 🛡️



Sistema de monitorização e deteção de anomalias em logs de auditoria, desenvolvido como parte do portfólio técnico para o Mestrado em Cybersecurity da \*\*Universidade de Brasília (UnB)\*\*.



\## 🚀 Funcionalidades Principais

\- \*\*Ingestão de Logs:\*\* Endpoint REST para receção de eventos de auditoria em formato JSON.

\- \*\*Motor Heurístico:\*\* Análise em tempo real baseada em regras de segurança.

\- \*\*Deteção de Anomalias:\*\*

&#x20; - Identificação de acesso fora do horário comercial (22h - 06h).

&#x20; - Validação de origem de rede (Filtro de IPs externos à rede 192.168.x.x).

&#x20; - Alerta por nível de criticidade (Risk Level HIGH/CRITICAL).



\## 🛠️ Stack Tecnológica

\- \*\*Java 21\*\* (LTS) - Utilizando Java Records para imutabilidade.

\- \*\*Spring Boot 3.3\*\*

\- \*\*Spring Security\*\* (Proteção de headers e mitigação de vulnerabilidades comuns).

\- \*\*Maven\*\* (Gestão de dependências e automação de build).



\## 📋 Como Testar

O projeto inclui um ficheiro `test-sentinel.http` para execução de testes rápidos via IntelliJ ou Cursor, validando a resposta HTTP 201 e os alertas no console.

