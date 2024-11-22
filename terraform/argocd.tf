provider "kubernetes" {
  config_path = "~/.kube/config"
}

provider "helm" {
  kubernetes {
    config_path = "~/.kube/config"
  }
}

resource "kubernetes_namespace" "argocd_app" {
  metadata {
    name = "argocd-app"
  }
}

resource "helm_release" "argocd_app" {
  name       = "argocd-app"
  namespace  = kubernetes_namespace.argocd_app.metadata[0].name
  repository = "https://argoproj.github.io/argo-helm"
  chart      = "argo-cd"
  version    = "4.5.4" 

  depends_on = [kubernetes_namespace.argocd_app]
}
