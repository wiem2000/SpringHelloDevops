resource "kubernetes_manifest" "argocd_metrics" {
  manifest = {
    apiVersion = "monitoring.coreos.com/v1"
    kind       = "ServiceMonitor"
    metadata = {
      name      = "argocd-metrics"
      namespace = "argocd-app"  # Updated namespace to argocd-app
      labels = {
        release = "prometheus-operator"
      }
    }
    spec = {
      selector = {
        matchLabels = {
          "app.kubernetes.io/name" = "argocd-metrics"
        }
      }
      namespaceSelector = {
        any = true
      }
      endpoints = [
        {
          port = "metrics"
        }
      ]
    }
  }
}

resource "kubernetes_manifest" "argocd_server_metrics" {
  manifest = {
    apiVersion = "monitoring.coreos.com/v1"
    kind       = "ServiceMonitor"
    metadata = {
      name      = "argocd-server-metrics"
      namespace = "argocd-app"  # Updated namespace to argocd-app
      labels = {
        release = "prometheus-operator"
      }
    }
    spec = {
      selector = {
        matchLabels = {
          "app.kubernetes.io/name" = "argocd-server-metrics"
        }
      }
      namespaceSelector = {
        any = true
      }
      endpoints = [
        {
          port = "metrics"
        }
      ]
    }
  }
}

resource "kubernetes_manifest" "argocd_repo_server_metrics" {
  manifest = {
    apiVersion = "monitoring.coreos.com/v1"
    kind       = "ServiceMonitor"
    metadata = {
      name      = "argocd-repo-server-metrics"
      namespace = "argocd-app"  # Updated namespace to argocd-app
      labels = {
        release = "prometheus-operator"
      }
    }
    spec = {
      selector = {
        matchLabels = {
          "app.kubernetes.io/name" = "argocd-repo-server"
        }
      }
      namespaceSelector = {
        any = true
      }
      endpoints = [
        {
          port = "metrics"
        }
      ]
    }
  }
}

