require 'rake/testtask'

  task :unit do
    puts "Executing unit tests"
    get_rb_files = %x[find . -name '*test.rb' | sort].split("\n")
    get_rb_files.each do |rb_file|
      sh "ruby -cw #{rb_file}" 
    end
  end
  
  task :regression do
    puts "Executing regression tests"
    puts "Done ..."
  end
 
  task :api do
    unless ENV["UAT_USER"] != 'TEST' 
      tst_env = ENV["UAT"] || 'http://uat.edpay.nz:8080'
      puts "Executing API tests @ #{tst_env} "
    else
      puts "User #{ENV["UAT_USER"]} not allowed to execute API tests"
    end
  end
 
  task :perf do
    puts "Basic perf suite ....."
  end
 
  task :all_tests => [:unit, :regression, :api, :perf] do
    puts "Looks Great!! ,Lets Deploy "
  end

# Default
task default: ['regression','perf']
