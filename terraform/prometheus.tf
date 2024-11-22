resource "helm_release" "prometheus" {
  name       = "prometheus"
  namespace  = "monitoring"
  repository = "https://prometheus-community.github.io/helm-charts"
  chart      = "kube-prometheus-stack"
  create_namespace = true

  values = [
    <<EOF
    prometheus:
      prometheusSpec:
        additionalScrapeConfigs:
          - job_name: 'argocd'
            kubernetes_sd_configs:
              - role: pod
                namespaces:
                  names:
                    - argocd-app 
            metrics_path: /metrics
            relabel_configs:
              - source_labels: [__meta_kubernetes_pod_label_app]
                target_label: app
    EOF
  ]
}

