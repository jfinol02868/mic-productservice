# Manifiestos Kubernetes — productservice

Generados automáticamente por **NX036 Platform**.

**Tipo detectado**: Java Spring Boot (Maven)
**Puerto sugerido**: 8080

## Importante

El `Deployment` lleva la imagen `ghcr.io/REPLACE/IMAGE:tag` como **placeholder**.
Tu CI/CD debe sustituirla por la imagen real que publica al registry:

```bash
# Ejemplo en GitHub Actions:
sed -i "s|ghcr.io/REPLACE/IMAGE:tag|ghcr.io/${{ github.repository }}:${{ github.sha }}|g" k8s/deployment.yaml
```

Argo CD sincronizará automáticamente los cambios cuando el commit llegue al branch.
