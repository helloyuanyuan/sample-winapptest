Vagrant.configure("2") do |config|
  config.vm.box = "baunegaard/win10pro-en"

  config.vm.define "automation"
  config.vm.hostname = "automation"
  config.vm.network "public_network"

  config.vm.provider "virtualbox" do |vb|
    vb.name = "automation"
    vb.memory = 8192
    vb.cpus = 2
  end

end
