Vagrant.configure("2") do |config|
  config.vm.box = "baunegaard/win10pro-en"
  config.vm.box_version = "1.4.0"
  config.vm.define "automationtest"
  config.vm.hostname = "automationtest"

  # config.vm.network "forwarded_port", guest: 4723, host: 4723
  # config.vm.network "private_network", ip: "192.168.56.125"
  config.vm.network "public_network"

  config.vm.provider "virtualbox" do |vb|
    vb.name = "automationtest"
    vb.memory = 8192
    vb.cpus = 2

  end

end
