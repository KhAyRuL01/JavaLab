data = input('Enter data:');
bitd = input('Enter bit duration:');
n = 100;
T = length(data)*bitd;
t = 0:1/n:T-1/n;
y = [];
flag = -1;
for i = 0:length(data)-1
    if data(i+1) == 0
        y(i*n*bitd+1:(i+1)*n*bitd) = 0;
    else
        if flag == 1
            y(i*n*bitd+1:(i+1)*n*bitd) = 1;
            flag = -1;
        else 
            y(i*n*bitd+1:(i+1)*n*bitd) = -1;
            flag = 1;
        end
    end
end
subplot(2,1,1)
plot(t,y);
axis([0, T, -5, 5])
seq = '000VB0VB';
decode='00011011';
flag = -1;
k = 0;
z = [];
for i = 0:length(data)-1
    if(i+k+1)>length(data)
        break;
    end
    if data(i+k+1) == 0
        z((i+k)*n*bitd+1:(i+k+1)*n*bitd) = 0;
        count = 0;
        for j = i+k:length(data)-1
           if data(j+1) == 0
                count = count+1;
           else 
               break;
           end
           if count == 8 
               break;
           end
        end
        if count == 8
            for j = 0:7
                if seq(j+1)=='V'
                    z((i+k+j)*n*bitd+1:(i+k+j+1)*n*bitd) = -1*flag;
                elseif seq(j+1)=='B'
                    z((i+k+j)*n*bitd+1:(i+j+k+1)*n*bitd) = flag;
                    flag = -1*flag;
                end
            end
            k = k+8;
        end     
    else
        if flag == 1
            z((i+k)*n*bitd+1:(i+k+1)*n*bitd) = 1;
            flag = -1;
        else 
            z((i+k)*n*bitd+1:(i+k+1)*n*bitd) = -1;
            flag = 1;
        end
    end
end
subplot(2,1,2)
plot(t,z);
axis([0, T, -5, 5])

dedata = [];
k = 1;
for i=[5:n:length(z)]
    if z(i)==1 || z(i)==-1
        dedata(k) = 1;
    else
        dedata(k) = 0;
    end
    k = k+1;
end
dedata

k = 0;
for i=1:length(dedata)
    flag = 1;
    if length(dedata)>=i+k+7
        for j = 0:7
            i+k+j
            j+1
            if dedata(i+k+j)~=decode(j+1)
                flag = 0;
                break;
            end
        end
        flag
        if flag==1
            dedata(i+k:i+k+7) = 0;
            k = k+7
        end
    end
    i+k
end
dedata
        


        
        
