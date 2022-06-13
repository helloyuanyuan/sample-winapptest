Vagrant.configure("2") do |config|
  config.vm.box = "gusztavvargadr/windows-server-2019-standard"
  config.vm.box_version = "1809.0.2205"
  config.vm.define "CompletionVagrantWindowsServer2019"
  config.vm.hostname = "CompletionVagrantWindowsServer2019"

  config.vm.network "public_network"

  config.vm.provider "virtualbox" do |vb|
    vb.name = "CompletionVagrantWindowsServer2019"
    vb.memory = 8192
    vb.cpus = 2
  end

  config.vm.provision "file", source: ".\\tools\\hosts", destination: "C:\\Windows\\System32\\drivers\\etc\\hosts"
  config.vm.provision "file", source: ".\\tools\\ICRpilot.Completion", destination: "C:\\ICRpilot.Completion"
  config.vm.provision :shell, path: ".\\script\\provision.ps1"

end
